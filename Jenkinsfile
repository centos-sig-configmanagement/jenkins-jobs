node('sig-configmanagement') {
    stage('Checkout') {
        git 'https://github.com/centos-sig-configmanagement/jenkins-jobs'
    }
    stage('Generate Seed Job and Folder') {
        jobDsl additionalClasspath: 'lib/*.jar', removedJobAction: 'DISABLE', removedViewAction: 'DELETE', targets: 'seed.groovy'
    }
//    stage('Generate Jobs') {
  //      jobDsl additionalClasspath: 'lib/*.jar', removedJobAction: 'DISABLE', removedViewAction: 'DELETE', targets: 'seeds/*.groovy'
    //}
}
