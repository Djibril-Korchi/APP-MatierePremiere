-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : ven. 29 mars 2024 à 08:03
-- Version du serveur : 8.2.0
-- Version de PHP : 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `dki_lestrelin`
--

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `id_classe` int NOT NULL AUTO_INCREMENT,
  `libelle` varchar(50) NOT NULL,
  `ref_filiere` int NOT NULL,
  PRIMARY KEY (`id_classe`),
  KEY `fk_classe_filiere` (`ref_filiere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

DROP TABLE IF EXISTS `commande`;
CREATE TABLE IF NOT EXISTS `commande` (
  `id_commande` int NOT NULL AUTO_INCREMENT,
  `prix` int NOT NULL,
  `date` date NOT NULL,
  `num_devie` int NOT NULL,
  `ref_user` int NOT NULL,
  PRIMARY KEY (`id_commande`),
  KEY `fk_commande_user` (`ref_user`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `concerne`
--

DROP TABLE IF EXISTS `concerne`;
CREATE TABLE IF NOT EXISTS `concerne` (
  `ref_debit` int NOT NULL,
  `ref_piece` int NOT NULL,
  KEY `fk_concerne_debit` (`ref_debit`),
  KEY `fk_concerne_piece` (`ref_piece`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `debit`
--

DROP TABLE IF EXISTS `debit`;
CREATE TABLE IF NOT EXISTS `debit` (
  `id_debit` int NOT NULL AUTO_INCREMENT,
  `date` date NOT NULL,
  `quantite` int NOT NULL,
  `ref_matiere` int NOT NULL,
  `ref_classe` int NOT NULL,
  `ref_user` int NOT NULL,
  PRIMARY KEY (`id_debit`),
  KEY `fk_debit_user` (`ref_user`),
  KEY `fk_debit_matiere` (`ref_matiere`),
  KEY `fk_debit_classe` (`ref_classe`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `filiere`
--

DROP TABLE IF EXISTS `filiere`;
CREATE TABLE IF NOT EXISTS `filiere` (
  `id_filiere` int NOT NULL AUTO_INCREMENT,
  `libelle` int NOT NULL,
  PRIMARY KEY (`id_filiere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `forme`
--

DROP TABLE IF EXISTS `forme`;
CREATE TABLE IF NOT EXISTS `forme` (
  `id_forme` int NOT NULL AUTO_INCREMENT,
  `forme` varchar(50) NOT NULL,
  `diametre` int NOT NULL,
  PRIMARY KEY (`id_forme`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

DROP TABLE IF EXISTS `fournisseur`;
CREATE TABLE IF NOT EXISTS `fournisseur` (
  `id_fournisseur` int NOT NULL AUTO_INCREMENT,
  `libelle` text NOT NULL,
  `rue` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `ville` varchar(50) NOT NULL,
  `cp` varchar(7) NOT NULL,
  `num` varchar(13) NOT NULL,
  `email` varchar(50) NOT NULL,
  PRIMARY KEY (`id_fournisseur`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `lier`
--

DROP TABLE IF EXISTS `lier`;
CREATE TABLE IF NOT EXISTS `lier` (
  `ref_commande` int NOT NULL,
  `ref_matiere` int NOT NULL,
  KEY `fk_lier_commande` (`ref_commande`),
  KEY `fk_lier_matiere` (`ref_matiere`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `materiaux`
--

DROP TABLE IF EXISTS `materiaux`;
CREATE TABLE IF NOT EXISTS `materiaux` (
  `id_materiaux` int NOT NULL AUTO_INCREMENT,
  `type_matériaux` varchar(50) NOT NULL,
  `quantite` int NOT NULL,
  PRIMARY KEY (`id_materiaux`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

DROP TABLE IF EXISTS `matiere`;
CREATE TABLE IF NOT EXISTS `matiere` (
  `id_matiere` int NOT NULL AUTO_INCREMENT,
  `longueur` int NOT NULL,
  `quantite` int NOT NULL,
  `prix` float NOT NULL,
  `ref_fournisseure` int NOT NULL,
  `ref_forme` int NOT NULL,
  PRIMARY KEY (`id_matiere`),
  KEY `fk_matiere_forme` (`ref_forme`),
  KEY `fk_matiere_fournisseure` (`ref_fournisseure`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `piece`
--

DROP TABLE IF EXISTS `piece`;
CREATE TABLE IF NOT EXISTS `piece` (
  `id_piece` int NOT NULL AUTO_INCREMENT,
  `libelle` varchar(50) NOT NULL,
  `image` text NOT NULL,
  `ref_system` int NOT NULL,
  PRIMARY KEY (`id_piece`),
  KEY `fk_piece_system` (`ref_system`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `possede`
--

DROP TABLE IF EXISTS `possede`;
CREATE TABLE IF NOT EXISTS `possede` (
  `ref_matiere` int NOT NULL,
  `ref_materiaux` int NOT NULL,
  KEY `fk_debit_matiere` (`ref_matiere`),
  KEY `fk_debit_materiaux` (`ref_materiaux`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `status`
--

DROP TABLE IF EXISTS `status`;
CREATE TABLE IF NOT EXISTS `status` (
  `id_status` int NOT NULL AUTO_INCREMENT,
  `role` varchar(11) NOT NULL,
  PRIMARY KEY (`id_status`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `status`
--

INSERT INTO `status` (`id_status`, `role`) VALUES
(1, 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `system`
--

DROP TABLE IF EXISTS `system`;
CREATE TABLE IF NOT EXISTS `system` (
  `id_system` int NOT NULL AUTO_INCREMENT,
  `libelle` varchar(50) NOT NULL,
  `image` varchar(50) NOT NULL,
  PRIMARY KEY (`id_system`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `id_user` int NOT NULL AUTO_INCREMENT,
  `nom` varchar(50) NOT NULL,
  `prenom` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mdp` varchar(50) NOT NULL,
  `ref_status` int NOT NULL,
  PRIMARY KEY (`id_user`),
  KEY `fk_user_status` (`ref_status`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id_user`, `nom`, `prenom`, `email`, `mdp`, `ref_status`) VALUES
(1, 'Korchi', 'Djibril', 'd.korchi@lprs.fr', 'azerty', 1);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `classe`
--
ALTER TABLE `classe`
  ADD CONSTRAINT `fk_classe_filiere` FOREIGN KEY (`ref_filiere`) REFERENCES `filiere` (`id_filiere`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `fk_commande_user` FOREIGN KEY (`ref_user`) REFERENCES `user` (`id_user`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `debit`
--
ALTER TABLE `debit`
  ADD CONSTRAINT `fk_debit_classe` FOREIGN KEY (`ref_classe`) REFERENCES `classe` (`id_classe`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `lier`
--
ALTER TABLE `lier`
  ADD CONSTRAINT `fk_lier_matiere` FOREIGN KEY (`ref_matiere`) REFERENCES `matiere` (`id_matiere`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `matiere`
--
ALTER TABLE `matiere`
  ADD CONSTRAINT `fk_matiere_fournisseure` FOREIGN KEY (`ref_fournisseure`) REFERENCES `fournisseur` (`id_fournisseur`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `piece`
--
ALTER TABLE `piece`
  ADD CONSTRAINT `fk_piece_system` FOREIGN KEY (`ref_system`) REFERENCES `system` (`id_system`) ON DELETE RESTRICT ON UPDATE RESTRICT;

--
-- Contraintes pour la table `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `fk_user_status` FOREIGN KEY (`ref_status`) REFERENCES `status` (`id_status`) ON DELETE RESTRICT ON UPDATE RESTRICT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
