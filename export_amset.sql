CREATE DATABASE IF NOT EXISTS amset;

--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID_UTILISATEUR` int NOT NULL AUTO_INCREMENT,
  `IDENTIFIANT` char(32) NOT NULL,
  `MOT_DE_PASSE` char(20) NOT NULL,
  `ROLE` char(32) NOT NULL,
  PRIMARY KEY (`ID_UTILISATEUR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

Insert INTO `utilisateur`(`ID_UTILISATEUR`, `IDENTIFIANT`, `MOT_DE_PASSE`, `ROLE`) VALUES  
(1, 't.xiong', 'txiong82', 'com'),
(2, 'b.bondoux', 'bbondoux82', 'rhu'),
(3, 'm.sage', 'smateo82', 'admin'),
(4, 'p.marquez', 'pmarquez31', 'com')

