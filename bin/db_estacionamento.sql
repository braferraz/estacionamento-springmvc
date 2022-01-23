-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 02-Out-2021 às 08:26
-- Versão do servidor: 10.4.17-MariaDB
-- versão do PHP: 7.3.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `db_estacionamento`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_movimentacao`
--

CREATE TABLE `tbl_movimentacao` (
  `id` int(11) NOT NULL,
  `placa` varchar(45) NOT NULL,
  `modelo` varchar(45) NOT NULL,
  `data_entrada` varchar(50) NOT NULL,
  `data_saida` varchar(50) DEFAULT NULL,
  `tempo` varchar(45) DEFAULT NULL,
  `valor_pago` decimal(13,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_movimentacao`
--

INSERT INTO `tbl_movimentacao` (`id`, `placa`, `modelo`, `data_entrada`, `data_saida`, `tempo`, `valor_pago`) VALUES
(1, 'GTR-9446', 'Nissan Skyline', '02/10/2021 01:40:38', NULL, NULL, '0.00'),
(2, 'HIL-1234', 'Toyota Hilux', '02/10/2021 01:41:18', '02/10/2021 01:41:46', '1', '6.00'),
(3, 'UPT-5123', 'Honda Civic', '02/10/2021 00:41:34', '02/10/2021 03:01:27', '2', '10.00'),
(4, 'FFF-1234', 'Ford Focus', '02/10/2021 01:42:01', NULL, NULL, '0.00'),
(5, 'FFF-1234', 'Ford Focus', '02/10/2021 01:42:01', '02/10/2021 01:42:52', '1', '6.00'),
(6, 'NIS-3500', 'Nissan 350z', '02/10/2021 02:03:09', NULL, NULL, '0.00'),
(7, 'HON-1524', 'Honda Fit', '02/10/2021 02:05:19', NULL, NULL, '0.00'),
(8, 'EFE-9992', 'Ford Fiesta', '02/10/2021 02:06:07', '02/10/2021 02:06:44', '1', '6.00'),
(9, 'FUS-1234', 'Fusca', '02/10/2021 02:35:37', '02/10/2021 02:47:54', '1', '6.00'),
(10, 'ASD-2324', 'Ford Fusion', '02/10/2021 03:00:26', '02/10/2021 03:01:02', '1', '6.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_usuario`
--

CREATE TABLE `tbl_usuario` (
  `id` int(11) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `user` varchar(255) NOT NULL,
  `senha` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_usuario`
--

INSERT INTO `tbl_usuario` (`id`, `nome`, `user`, `senha`) VALUES
(1, 'admin', 'admin', '123456');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbl_valor`
--

CREATE TABLE `tbl_valor` (
  `id` int(11) NOT NULL,
  `valor_primeira_hora` decimal(13,2) NOT NULL,
  `valor_demais_horas` decimal(13,2) NOT NULL,
  `data_fim` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Extraindo dados da tabela `tbl_valor`
--

INSERT INTO `tbl_valor` (`id`, `valor_primeira_hora`, `valor_demais_horas`, `data_fim`) VALUES
(1, '6.00', '4.00', 'null');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tbl_movimentacao`
--
ALTER TABLE `tbl_movimentacao`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  ADD PRIMARY KEY (`id`);

--
-- Índices para tabela `tbl_valor`
--
ALTER TABLE `tbl_valor`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tbl_movimentacao`
--
ALTER TABLE `tbl_movimentacao`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de tabela `tbl_usuario`
--
ALTER TABLE `tbl_usuario`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `tbl_valor`
--
ALTER TABLE `tbl_valor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
