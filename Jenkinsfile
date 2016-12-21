node('sig-configmanagement') {
    stage('Checkout') {
        checkout scm
    }
    stage('Generate Jobs') {
        jobDsl additionalClasspath: 'lib/*.jar', removedJobAction: 'DISABLE', removedViewAction: 'DELETE', targets: 'seeds/*.groovy'
    }
}
