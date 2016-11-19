node('sig-configmanagement') {
    stage('checkout') {
        git url: 'https://github.com/centos-sig-configmanagement/jenkins-jobs'
    }
    stage('setup virtualenv') {
        sh './ci/setup-virtualenv.sh'
    }
    stage('testing') {
        sh './ci/test.sh'
    }
}
