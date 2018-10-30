const express = require('express');
const router = express.Router();

const produto_controller = require('../controllers/produto.controller');

router.get('/teste', produto_controller.teste);
router.get('/:id', produto_controller.detalhar);
router.post('/criar', produto_controller.criar);
router.put('/:id/atualizar', produto_controller.atualizar);
router.delete('/:id/excluir', produto_controller.excluir);

module.exports = router;