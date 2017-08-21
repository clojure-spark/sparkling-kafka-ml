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
