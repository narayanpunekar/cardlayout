pipeline {
    agent any 
    options { timeout(time: 30) }
    stages {
        stage("Stage One") {
            steps {
                sleep 30
                echo 'Step 1. Hello World'
            }
        }
        stage("Stage Two") {
            steps {
                echo 'Step 2. Hello Hello World'
                echo 'Step 3. Hello Hello Hello World'
            }
        }
        stage("Checkout") {
            steps {
                echo 'git url: https://github.com/narayanpunekar/cardlayout.git'
                git url: 'https://github.com/narayanpunekar/cardlayout.git'
            }
        }
        stage("Compile") {
            steps {
                sh "/var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/maven363/bin/mvn clean compile"
            }
        }
		stage("Package") {
            steps {
                sh "/var/jenkins_home/tools/hudson.tasks.Maven_MavenInstallation/maven363/bin/mvn package"
            }
		}
		stage("Docker build") {
			steps {
				sh "docker build -t npunekar/cardlayout ."
			}
		}
		stage("Docker push") {
			steps {
				sh "docker push npunekar/cardlayout"
			}
		}
    }
    post {
        always {
            mail to: 'narayan.v.punekar@gmail.com',
            subject: "Completed Pipeline: ${currentBuild.fullDisplayName}", 
            body: "Build completed, ${env.BUILD_URL}"
        }
    }
} 

