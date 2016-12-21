package utilities
import org.yaml.snakeyaml.Yaml
import groovy.json.StringEscapeUtils

class MagicParameters {
    static void addParameters(def job, def object) {
        def message = '<div class="warning">Automatically set by Jenkins Job DSL plugin. Do not change this.</div>'
        object.each {
            name, value ->
                if (value instanceof String) {
                    if (value.contains("\n")) {
                        job.with {
                            parameters {
                                textParam(name, value, message)
                            }
                        }
                    } else {
                        job.with {
                            parameters {
                                stringParam(name, value, message)
                            }
                        }
                    }
                } else if (value instanceof Boolean) {
                    job.with {
                        parameters {
                            booleanParam(name, value, message)
                        }
                    }
                } else if (value instanceof Integer) {
                    job.with {
                        parameters {
                            stringParam(name, "${value}", message)
                        }
                    }
                } else if (value instanceof List<String>) {
                    job.with {
                        parameters {
                            textParam(name, "${value.join("\n")}", message)
                        }
                    }
                } else {
                    job.with {
                        parameters {
                            Yaml myYaml = new Yaml()
                            textParam(name, myYaml.dump(value), message)
                        }
                    }
                }
            }
    }
}
