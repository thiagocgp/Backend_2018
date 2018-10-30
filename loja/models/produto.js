const mongoose = require('mongoose');
const Schema = mongoose.Schema;

let ProdutoSchema = new Schema({
    nome: {type: String, required: true, max: 100},
    preco: {type: Number, required: true},
});

module.exports = mongoose.model('Produto', ProdutoSchema);