-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tiempo de generación: 16-08-2016 a las 19:14:48
-- Versión del servidor: 5.0.51
-- Versión de PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Base de datos: `Proy1Github`
-- 

-- --------------------------------------------------------

-- 
-- Estructura de tabla para la tabla `usuario`
-- 

CREATE TABLE `usuario` (
  `idUsuario` int(10) unsigned NOT NULL auto_increment,
  `Nombre` varchar(12) NOT NULL,
  `Apellido` varchar(12) NOT NULL,
  `Usuario` varchar(12) NOT NULL,
  `Pass` varchar(12) NOT NULL,
  PRIMARY KEY  (`idUsuario`),
  UNIQUE KEY `Usuario` (`Usuario`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

-- 
-- Volcar la base de datos para la tabla `usuario`
-- 

INSERT INTO `usuario` VALUES (1, 'Josue', 'Aquino', 'joss', '123');
INSERT INTO `usuario` VALUES (2, 'Sindy', 'Epiquien', 'raquely', '1002');
INSERT INTO `usuario` VALUES (3, 'Alex', 'Sanchez', 'pinky', '1234');
