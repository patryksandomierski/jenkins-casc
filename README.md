# jenkins-casc

## Startup
Run script (make it executable `chmod +x start.sh`):
```
./start.sh
```
It will stop an already running container, pull, build, start and open Jenkins' logs with `-f` flag (follow)

## Structure
```
.
├── casc                            # all configuration files for CasC
│   ├── jenkins.yaml
│   ├── jobs.yaml
│   ├── security.yaml
│   ├── tool.yaml
│   └── unclassified.yaml
├── docker-compose.yaml             # docker compose for starting container
├── Dockerfile                      # docker file for building image
├── jobs                            # director with pipelines
│   ├── dsl                         # directory with pipelines definitions
│   │   └── sample_job.groovy
│   └── sample-job.groovy
├── plugins.txt                     # list of plugins with version for building image
├── pom.xml                         # maven pom with dependecies (especially for tests)
├── src                             # sources for jenkins-shared library
│   └── org
│       └── patsan
│           └── Sample.groovy
├── start.sh                        # starting script for faster testing
└── test                            # test for library and pipelines
    └── org
        └── patsan
            └── SampleTest.groovy
```
