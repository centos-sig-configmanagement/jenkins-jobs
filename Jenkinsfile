node('sig-configmanagement') {
    stage('Checkout') {
        git url: 'https://github.com/centos-sig-configmanagement/jenkins-jobs'
    }
    stage('Test') {
        sh './ci/test.sh'
    }
    stage('Publish') {
        sh './ci/publish.sh'
    }
}
