const express = require("express");
const axios = require("axios");

const router = express.Router();

// accueil
router.get("/", (req, res) => {
  res.render("index");
});

// page add
router.get("/add", (req, res) => {
  res.render("addStudent");
});

// submit add
router.post("/add", async (req, res) => {
  await axios.post(
    "http://ws-template:8800/service/student/add",
    req.body,
    { headers: { "x-api-key": "CAFEBABE" } }
  );
  res.redirect("/");
});

// page list
router.get("/list", async (req, res) => {
  const response = await axios.get(
    "http://ws-template:8800/service/students",
    { headers: { "x-api-key": "CAFEBABE" } }
  );
  res.render("listStudent", { students: response.data });
});


module.exports = router;
