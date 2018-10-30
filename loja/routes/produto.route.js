const express = require('express');
const router = express.Router();

const produto_controller = require('../controllers/produto.controller');

router.get('/registros', produto_controller.registros);
router.get('/registro', produto_controller.registros);
router.get('/busca/:id', produto_controller.detalhar);
router.post('/criar', produto_controller.criar);
router.put('/atualizar/:id', produto_controller.atualizar);
router.delete('/excluir/:id', produto_controller.excluir);

module.exports = router;