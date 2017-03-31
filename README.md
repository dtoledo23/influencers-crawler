# wizeline-bot-analytics-backup
Broker consumer for backing up logs as files

# How to set up
- Edit configuration file under `src/main/resources/application.conf`
- Setup AWS keys. Set both keyId and secretKey either as a environment variable
using the `start-services.sh` file. Or include them on the config file specified
above.

# Run manually
- Install `maven`
- `mvn package`
- `java -jar target/LogsBackup-jar-with-dependencies.jar`

# Run with docker
- `docker build -t analytics-backup .`
- `docker run -it analytics-backup`
# influencers-crawler
