-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 15 Nis 2020, 21:37:17
-- Sunucu sürümü: 10.4.11-MariaDB
-- PHP Sürümü: 7.2.29

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `ogrencitakip`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `bolum`
--

CREATE TABLE `bolum` (
  `ID` int(11) NOT NULL,
  `Adi` varchar(50) DEFAULT NULL,
  `Aciklama` varchar(150) DEFAULT NULL,
  `Eposta` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Tablo döküm verisi `bolum`
--

INSERT INTO `bolum` (`ID`, `Adi`, `Aciklama`, `Eposta`) VALUES
(10, 'Bil. Muh.', 'bilgisayar müh', 'bilmuh@isparta.edu.tr');

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ders`
--

CREATE TABLE `ders` (
  `ID` int(11) NOT NULL,
  `Adi` varchar(50) DEFAULT NULL,
  `Kodu` varchar(50) DEFAULT NULL,
  `Kredi` int(2) DEFAULT NULL,
  `BolumID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `derssorumluders`
--

CREATE TABLE `derssorumluders` (
  `DersSorumluID` int(11) DEFAULT NULL,
  `DersID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `derssorumlusu`
--

CREATE TABLE `derssorumlusu` (
  `ID` int(11) NOT NULL,
  `Adi` varchar(50) DEFAULT NULL,
  `Soyadi` varchar(50) DEFAULT NULL,
  `DogumYeri` varchar(50) DEFAULT NULL,
  `BolumID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kitap`
--

CREATE TABLE `kitap` (
  `ID` int(11) NOT NULL,
  `ISBNo` varchar(50) DEFAULT NULL,
  `KitapAd` varchar(100) DEFAULT NULL,
  `SayfaSayisi` int(11) NOT NULL,
  `YazarID` int(11) DEFAULT NULL,
  `TurID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kitapislem`
--

CREATE TABLE `kitapislem` (
  `ID` int(11) NOT NULL,
  `OgrenciNo` varchar(20) DEFAULT NULL,
  `KitapID` int(11) DEFAULT NULL,
  `AlisTarih` date DEFAULT NULL,
  `VerilisTarih` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kitaptur`
--

CREATE TABLE `kitaptur` (
  `ID` int(11) NOT NULL,
  `Ad` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `kitapyazar`
--

CREATE TABLE `kitapyazar` (
  `ID` int(11) NOT NULL,
  `Ad` varchar(50) DEFAULT NULL,
  `Soyad` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ogrenci`
--

CREATE TABLE `ogrenci` (
  `ID` int(11) NOT NULL,
  `OgrenciNo` varchar(20) DEFAULT NULL,
  `Adi` varchar(100) DEFAULT NULL,
  `Soyadi` varchar(100) DEFAULT NULL,
  `DogumTarih` date DEFAULT NULL,
  `DogumYeri` varchar(50) DEFAULT NULL,
  `Cinsiyet` varchar(20) DEFAULT NULL,
  `Adres` varchar(150) DEFAULT NULL,
  `BolumID` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ogrenciders`
--

CREATE TABLE `ogrenciders` (
  `ID` int(11) NOT NULL,
  `OgrenciNo` varchar(20) DEFAULT NULL,
  `DersID` int(11) DEFAULT NULL,
  `DersNotu` varchar(3) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `ogrencikitap`
--

CREATE TABLE `ogrencikitap` (
  `OgrenciNo` varchar(20) NOT NULL,
  `Puan` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `bolum`
--
ALTER TABLE `bolum`
  ADD PRIMARY KEY (`ID`);

--
-- Tablo için indeksler `ders`
--
ALTER TABLE `ders`
  ADD PRIMARY KEY (`ID`);

--
-- Tablo için indeksler `derssorumlusu`
--
ALTER TABLE `derssorumlusu`
  ADD PRIMARY KEY (`ID`);

--
-- Tablo için indeksler `kitap`
--
ALTER TABLE `kitap`
  ADD PRIMARY KEY (`ID`);

--
-- Tablo için indeksler `kitaptur`
--
ALTER TABLE `kitaptur`
  ADD PRIMARY KEY (`ID`);

--
-- Tablo için indeksler `kitapyazar`
--
ALTER TABLE `kitapyazar`
  ADD PRIMARY KEY (`ID`);

--
-- Tablo için indeksler `ogrenci`
--
ALTER TABLE `ogrenci`
  ADD PRIMARY KEY (`ID`);

--
-- Tablo için indeksler `ogrenciders`
--
ALTER TABLE `ogrenciders`
  ADD PRIMARY KEY (`ID`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `bolum`
--
ALTER TABLE `bolum`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Tablo için AUTO_INCREMENT değeri `ders`
--
ALTER TABLE `ders`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `derssorumlusu`
--
ALTER TABLE `derssorumlusu`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `kitap`
--
ALTER TABLE `kitap`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `kitaptur`
--
ALTER TABLE `kitaptur`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `kitapyazar`
--
ALTER TABLE `kitapyazar`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `ogrenci`
--
ALTER TABLE `ogrenci`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;

--
-- Tablo için AUTO_INCREMENT değeri `ogrenciders`
--
ALTER TABLE `ogrenciders`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
