const { Kafka } = require("kafkajs");

const kafka = new Kafka({
  clientId: "front",
  brokers: ["kafka:9092"]
});

const consumer = kafka.consumer({ groupId: "front-group" });

global.students = [];

async function run() {
  await consumer.connect();
  await consumer.subscribe({ topic: "ListStudent", fromBeginning: true });

  await consumer.run({
    eachMessage: async ({ message }) => {
      global.students = JSON.parse(message.value.toString());
      console.log("Liste reçue :", global.students);
    }
  });
}

run();
