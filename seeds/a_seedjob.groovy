import jenkins.model.Jenkins

def scriptApproval = Jenkins.instance.getExtensionList('org.jenkinsci.plugins.scriptsecurity.scripts.ScriptApproval')[0]

def folderName = "sig-configmanagement"

folder(folderName){
    displayName("Configuration Management SIG")
}

pipelineJob("${folderName}") {
    displayName("Configuration Management SIG / Seed Job")
    buildScript = readFileFromWorkspace('Jenkinsfile')
    scriptApproval.approveScript(scriptApproval.hash(buildScript, 'groovy'))
    definition {
        cps {
            script(buildScript)
        }
    }
}
