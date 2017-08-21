(ns sparkling-kafka-ml.core
  (:require
   [sparkling.conf :as conf]
   [sparkling.core :as spark]
   [sparkling.function :refer [function2]]
   [sparkling.scalaInterop :as scala]
   [clojure.tools.logging :as log])
  (:import (kafka.serializer StringDecoder)
           (org.apache.spark.api.java JavaSparkContext)
           (org.apache.spark.streaming Duration)
           (org.apache.spark.streaming.api.java JavaPairInputDStream)
           (org.apache.spark.streaming.api.java JavaStreamingContext)
           (org.apache.spark.streaming.kafka KafkaUtils)
           (java.util Collections)
           (java.util HashMap)
           (java.util Map)
           (java.util Set))
  (:gen-class))

(defn -main
  [& args]
  (let [c (-> (conf/spark-conf)
              (conf/master "local[*]")
              (conf/app-name "Consumer"))
        context (JavaSparkContext. c)
        streaming-context (JavaStreamingContext. context (Duration. 1000))
        parameters (HashMap. {"metadata.broker.list" "127.0.0.1:9092"})
        topics (Collections/singleton "w4u_messages")
        stream (KafkaUtils/createDirectStream streaming-context String String StringDecoder StringDecoder parameters topics)]
    (do
      (.print stream)
      (.start streaming-context)
      (.awaitTermination streaming-context))))
