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
  await axios.post("http://ws-template:8080/students", req.body);
  res.redirect("/");
});

// page list
router.get("/list", async (req, res) => {
  // déclenche la demande via REST
  await axios.get("http://ws-template:8080/students");
  res.render("listStudent", { students: global.students || [] });
});

module.exports = router;
