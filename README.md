# wizeline-bot-analytics-backup
Broker consumer for backing up logs as files

# How to set up
- Install Spark `brew install apache-spark`
- Install Maven `brew install maven`
- Install Java8

- Create file `/Users/toledo/file.log` with the data to analyze.

# Run manually
- git clone `git@github.com:dtoledo23/influencers-crawler.git`
- `cd influencers-crawler`
- `mvn package`
- `spark-submit target/influencer-crawler-0.0.1-jar-with-dependencies.jar`
- See the results in the console.
