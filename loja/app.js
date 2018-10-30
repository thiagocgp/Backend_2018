const express = require('express');
const bodyParser = require('body-parser')

const produto = require('./routes/produto.route');
const app = express();

// Criando conexão com o banco mongoose
const mongoose = require('mongoose');
let dev_db_url = 'mongodb://usuario:usuario12345@ds157639.mlab.com:57639/lojadwm'
let mongoDB = process.env.MONGODB_URI || dev_db_url;
mongoose.connect(mongoDB, { useNewUrlParser: true });
mongoose.Promise = global.Promise;
let db = mongoose.connection;
db.on('error', console.error.bind(console, 'MongoDB connection error:'));

app.use(bodyParser.urlencoded({extended: false}));
app.use(bodyParser.json());
app.use('/loja', produto);
app.get('/', function(req, res){
    res.redirect('/loja');
});
app.get('/loja', function(req, res){
    res.send('Bem vindo a loja');
});

var port = 1234;

app.listen(port, () => {
    console.log('O servidor iniciou com a porta ' + port);
});