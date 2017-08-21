(defproject sparkling-kafka-ml "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [gorillalabs/sparkling "2.1.2"]
                 [org.apache.spark/spark-streaming_2.11 "2.2.0"]
                 [org.apache.spark/spark-streaming-kafka_2.11 "1.6.3"]
                 [org.apache.spark/spark-streaming-flume_2.11 "2.2.0"]
                 [org.apache.spark/spark-mllib_2.11 "2.2.0"]]
  :aot [#".*" sparkling.serialization sparkling.destructuring]
  :java-source-paths ["src/java"]
  :main sparkling-kafka-ml.core)
