node('sig-configmanagement') {
    stage('Checkout') {
        git url: 'https://github.com/centos-sig-configmanagement/jenkins-jobs'
    }
    stage('Setup') {
        sh './ci/setup-virtualenv.sh'
    }
    stage('Test') {
        sh './ci/test.sh'
    }
    stage('Publish') {
        sh './ci/publish.sh'
    }
}
