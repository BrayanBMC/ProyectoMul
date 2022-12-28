-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-12-2022 a las 04:16:23
-- Versión del servidor: 10.4.24-MariaDB
-- Versión de PHP: 7.4.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `vehiculosud`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `auto`
--

CREATE TABLE `auto` (
  `placaA` varchar(60) NOT NULL,
  `modeloA` int(11) NOT NULL,
  `marcaA` varchar(60) NOT NULL,
  `valorA` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `auto`
--

INSERT INTO `auto` (`placaA`, `modeloA`, `marcaA`, `valorA`) VALUES
('ABC223', 2005, 'Chevrolet', 1500000);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `formulario`
--

CREATE TABLE `formulario` (
  `nroF` varchar(60) NOT NULL,
  `fechV` date NOT NULL,
  `horaV` time NOT NULL,
  `FK_nombreP` varchar(60) NOT NULL,
  `tipoV` varchar(60) NOT NULL,
  `FK_placaV` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `moto`
--

CREATE TABLE `moto` (
  `placaM` varchar(60) NOT NULL,
  `modeloM` int(11) NOT NULL,
  `marcaM` varchar(60) NOT NULL,
  `valorM` double NOT NULL,
  `cilindrajeM` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `nombreP` varchar(60) NOT NULL,
  `emailP` varchar(60) NOT NULL,
  `idP` varchar(10) NOT NULL,
  `telefonoP` varchar(10) NOT NULL,
  `fNacP` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`nombreP`, `emailP`, `idP`, `telefonoP`, `fNacP`) VALUES
('Stiven Velasquez', 'angeldarkerz@gmail.com', '1024598166', '7156623', 23);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `auto`
--
ALTER TABLE `auto`
  ADD PRIMARY KEY (`placaA`);

--
-- Indices de la tabla `formulario`
--
ALTER TABLE `formulario`
  ADD PRIMARY KEY (`nroF`),
  ADD KEY `FK_nombreP` (`FK_nombreP`),
  ADD KEY `FK_placaV` (`FK_placaV`);

--
-- Indices de la tabla `moto`
--
ALTER TABLE `moto`
  ADD PRIMARY KEY (`placaM`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`idP`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
