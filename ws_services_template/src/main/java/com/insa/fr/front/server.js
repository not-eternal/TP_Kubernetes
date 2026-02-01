const express = require("express");
const bodyParser = require("body-parser");

const studentRoutes = require("./routes/students");


const app = express();
app.set("view engine", "ejs");

app.use(bodyParser.urlencoded({ extended: false }));
app.use(express.static("public"));

app.use("/", studentRoutes);

app.listen(3000, () => {
  console.log("Front lancé sur http://localhost:3000");
});

/* Kafka uniquement si activé */
if (process.env.KAFKA_ENABLED === "true") {
  require("./kafka/consumerListStudent");
}