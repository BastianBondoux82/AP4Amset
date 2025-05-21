
--
-- Structure de la table `utilisateur`
--

DROP TABLE IF EXISTS `utilisateur`;
CREATE TABLE IF NOT EXISTS `utilisateur` (
  `ID_UTILISATEUR` int NOT NULL AUTO_INCREMENT,
  `IDENTIFIANT` char(32) NOT NULL,
  `NOM` char(32) NOT NULL,
  `PRENOM` char(32) NOT NULL,
  `EMAIL` char(32) NOT NULL,
  `MOT_DE_PASSE` char(32) NOT NULL,
  PRIMARY KEY (`ID_UTILISATEUR`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`ID_UTILISATEUR`, `IDENTIFIANT`, `PRENOM`, `EMAIL`, `MOT_DE_PASSE`) VALUES
(1, 'txiong', 'Teddy', 'teddy.xiong@amset.com', 'Txiong82Amset'),
(2, 'msage', 'Mateo', 'mateo.sage@amset.com', 'Msage82Amset'),
(3, 'mperot', 'Mathis', 'mathis.perot@amset.com', 'Mperot82Amset'),
(4, 'bbondoux', 'Bastian', 'bastian.bondoux@amset.com', 'Bbondoux82Amset'),
(5, 'ezimmermann', 'Ethane', 'ethane.zimmermann@amset.com', 'Ezimmermann82Amset'),
(6, 'pmarquez', 'Paul', 'paul.marquez@amset.com', 'Pmarquez82Amset'),
(7, 'test', 'admin', 'admin@amset.com', 'tt');

