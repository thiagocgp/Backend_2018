const Produto = require('../models/produto');

exports.registros = function(req, res){
    // res.send('Saudações do teste controller');
    Produto.find(function (err, produtos){
        if(err) return next(err);
        res.send(produtos);
    })
};

exports.criar = function (req, res) {
    var produto = new Produto(
        {
            nome: req.body.nome,
            preco: req.body.preco
        }
    );

    produto.save(function (err) {
        if (err) {
            return next(err);
        }
        res.send('Produto criado com sucesso')
    })
};

exports.buscar = function (req, res) {
    Produto.findById(req.params.id, function (err, produto){
        if(err) return next(err);
        res.send(produto);
    })
};

exports.atualizar = function (req, res) {
    Produto.findByIdAndReplace(req.params.id, {$set: req.body}, function (err, produto) {
        if (err) return next(err);
        res.send('Produto atualizado');
    });
};

exports.excluir = function (req, res) {
    Produto.findByIdAndRemove(req.params.id, function (err) {
        if (err) return next(err);
        res.send('Excluido com sucesso');
    })
};

exports.compra = function (req, res) {
    var query = { nome: req.params.nome };
    Produto.find(query, function (err, produto) {
        if(err) return next(err);
        res.send(produto + ' ' + req.params.quant);
    })
};

/* */



