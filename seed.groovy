import jenkins.model.Jenkins
import org.yaml.snakeyaml.Yaml
import seeds.utilities.MagicParameters

Yaml myYaml = new Yaml()
def scriptApproval = Jenkins.instance.getExtensionList('org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval')[0]

def globalMap = myYaml.load(readFileFromWorkspace('cfg/global.yaml'))

def folderName = "sig-configmanagement"

folder(folderName){
    displayName("Configuration Management SIG")
}

job = pipelineJob("${folderName}/seed") {
    displayName("Seed Job")

    properties {
        githubProjectUrl("${globalMap.githubUrlPrefix}/${globalMap.seedRepo}")
    }

    triggers {
        githubPush()
    }

    buildScript = readFileFromWorkspace('Jenkinsfile')
    scriptApproval.approveScript(scriptApproval.hash(buildScript, 'groovy'))
    definition {
        cps {
            script(buildScript)
        }
    }
}
MagicParameters.addParameters(job, globalMap)
