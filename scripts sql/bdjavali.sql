-- --------------------------------------------------------
-- Servidor:                     localhost
-- Versão do servidor:           5.6.16 - MySQL Community Server (GPL)
-- OS do Servidor:               Win64
-- HeidiSQL Versão:              8.3.0.4694
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- Copiando estrutura do banco de dados para bdjavali
CREATE DATABASE IF NOT EXISTS `bdjavali` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bdjavali`;


-- Copiando estrutura para tabela bdjavali.chamado
DROP TABLE IF EXISTS `chamado`;
CREATE TABLE IF NOT EXISTS `chamado` (
  `idChamado` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `descricao` varchar(2048) DEFAULT NULL,
  `data_criacao` datetime NOT NULL,
  `data_inicio` datetime DEFAULT NULL,
  `data_fim` datetime DEFAULT NULL,
  `idUsuario_criador` int(11) NOT NULL,
  `idProjeto` int(11) NOT NULL,
  PRIMARY KEY (`idChamado`),
  UNIQUE KEY `numero_UNIQUE` (`numero`),
  KEY `fk_Chamado_Usuario1_idx` (`idUsuario_criador`),
  KEY `fk_Chamado_Projeto1_idx` (`idProjeto`),
  CONSTRAINT `fk_Chamado_Projeto1` FOREIGN KEY (`idProjeto`) REFERENCES `projeto` (`idProjeto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Chamado_Usuario1` FOREIGN KEY (`idUsuario_criador`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela bdjavali.chamado_has_tarefa
DROP TABLE IF EXISTS `chamado_has_tarefa`;
CREATE TABLE IF NOT EXISTS `chamado_has_tarefa` (
  `Chamado_idChamado` int(11) NOT NULL,
  `Tarefa_idTarefa` int(11) NOT NULL,
  PRIMARY KEY (`Chamado_idChamado`,`Tarefa_idTarefa`),
  KEY `fk_Chamado_has_Tarefa_Tarefa1_idx` (`Tarefa_idTarefa`),
  KEY `fk_Chamado_has_Tarefa_Chamado1_idx` (`Chamado_idChamado`),
  CONSTRAINT `fk_Chamado_has_Tarefa_Chamado1` FOREIGN KEY (`Chamado_idChamado`) REFERENCES `chamado` (`idChamado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Chamado_has_Tarefa_Tarefa1` FOREIGN KEY (`Tarefa_idTarefa`) REFERENCES `tarefa` (`idTarefa`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela bdjavali.projeto
DROP TABLE IF EXISTS `projeto`;
CREATE TABLE IF NOT EXISTS `projeto` (
  `idProjeto` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `descricao` varchar(2048) DEFAULT NULL,
  `data_criacao` datetime NOT NULL,
  `data_fim` datetime DEFAULT NULL,
  PRIMARY KEY (`idProjeto`),
  UNIQUE KEY `idProjeto_UNIQUE` (`idProjeto`),
  UNIQUE KEY `nome_UNIQUE` (`nome`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela bdjavali.tarefa
DROP TABLE IF EXISTS `tarefa`;
CREATE TABLE IF NOT EXISTS `tarefa` (
  `idTarefa` int(11) NOT NULL AUTO_INCREMENT,
  `numero` int(11) NOT NULL,
  `titulo` varchar(45) NOT NULL,
  `descricao` varchar(2048) DEFAULT NULL,
  `data_criacao` datetime NOT NULL,
  `data_inicio` datetime DEFAULT NULL,
  `data_fim` datetime DEFAULT NULL,
  `idProjeto` int(11) NOT NULL,
  PRIMARY KEY (`idTarefa`),
  UNIQUE KEY `idTarefa_UNIQUE` (`idTarefa`),
  UNIQUE KEY `numero_UNIQUE` (`numero`),
  KEY `fk_Tarefa_Projeto1_idx` (`idProjeto`),
  CONSTRAINT `fk_Tarefa_Projeto1` FOREIGN KEY (`idProjeto`) REFERENCES `projeto` (`idProjeto`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela bdjavali.usuario
DROP TABLE IF EXISTS `usuario`;
CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(45) NOT NULL,
  `senha` varchar(32) NOT NULL,
  `nome` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `foto` varchar(45) DEFAULT NULL,
  `ativo` smallint(6) DEFAULT '1',
  `data_criacao` datetime NOT NULL,
  `data_delecao` datetime DEFAULT NULL,
  PRIMARY KEY (`idUsuario`),
  UNIQUE KEY `idUsuario_UNIQUE` (`idUsuario`),
  UNIQUE KEY `login_UNIQUE` (`login`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela bdjavali.usuario_has_projeto
DROP TABLE IF EXISTS `usuario_has_projeto`;
CREATE TABLE IF NOT EXISTS `usuario_has_projeto` (
  `Usuario_idUsuario` int(11) NOT NULL,
  `Projeto_idProjeto` int(11) NOT NULL,
  PRIMARY KEY (`Usuario_idUsuario`,`Projeto_idProjeto`),
  KEY `fk_Usuario_has_Projeto_Projeto1_idx` (`Projeto_idProjeto`),
  KEY `fk_Usuario_has_Projeto_Usuario_idx` (`Usuario_idUsuario`),
  CONSTRAINT `fk_Usuario_has_Projeto_Projeto1` FOREIGN KEY (`Projeto_idProjeto`) REFERENCES `projeto` (`idProjeto`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_Projeto_Usuario` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela bdjavali.usuario_has_tarefa
DROP TABLE IF EXISTS `usuario_has_tarefa`;
CREATE TABLE IF NOT EXISTS `usuario_has_tarefa` (
  `Usuario_idUsuario` int(11) NOT NULL,
  `Tarefa_idTarefa` int(11) NOT NULL,
  PRIMARY KEY (`Usuario_idUsuario`,`Tarefa_idTarefa`),
  KEY `fk_Usuario_has_Tarefa_Tarefa1_idx` (`Tarefa_idTarefa`),
  KEY `fk_Usuario_has_Tarefa_Usuario1_idx` (`Usuario_idUsuario`),
  CONSTRAINT `fk_Usuario_has_Tarefa_Tarefa1` FOREIGN KEY (`Tarefa_idTarefa`) REFERENCES `tarefa` (`idTarefa`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_Tarefa_Usuario1` FOREIGN KEY (`Usuario_idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.


-- Copiando estrutura para tabela bdjavali.usuario_role
DROP TABLE IF EXISTS `usuario_role`;
CREATE TABLE IF NOT EXISTS `usuario_role` (
  `idUsuario_Role` int(11) NOT NULL AUTO_INCREMENT,
  `role` varchar(10) NOT NULL,
  `idUsuario` int(11) NOT NULL,
  PRIMARY KEY (`idUsuario_Role`),
  KEY `fk_Usuario_Role_Usuario1_idx` (`idUsuario`),
  CONSTRAINT `fk_Usuario_Role_Usuario1` FOREIGN KEY (`idUsuario`) REFERENCES `usuario` (`idUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Exportação de dados foi desmarcado.
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;

INSERT INTO `bdjavali`.`usuario` (`idUsuario`, `login`, `senha`, `nome`, `email`, `data_criacao`) VALUES (1, 'admin', '21232f297a57a5a743894a0e4a801fc3', 'Daniel Cavalcante', 'danielnkt@gmail.com', '2015-06-04 16:41:10');
INSERT INTO `bdjavali`.`usuario` (`idUsuario`, `login`, `senha`, `nome`, `email`, `data_criacao`) VALUES (2, 'javalininja', '21232f297a57a5a743894a0e4a801fc3', 'Javali Ninja', 'javalininja@gmail.com', '2015-06-04 16:41:10');
