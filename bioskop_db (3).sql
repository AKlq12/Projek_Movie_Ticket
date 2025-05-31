-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 31, 2025 at 03:12 AM
-- Server version: 10.4.28-MariaDB
-- PHP Version: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bioskop_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id_admin` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id_admin`, `email`, `username`, `password`, `created_at`) VALUES
(1, 'afif12@gmail.com', 'aklq12', 'd953ce5d14f2d1ed16b74876d8abefedd3a2bfa48183787d585de44c8b7b4431', '2025-05-29 04:46:44'),
(2, 'afif@gmail.com', 'afif123', 'd953ce5d14f2d1ed16b74876d8abefedd3a2bfa48183787d585de44c8b7b4431', '2025-05-29 05:03:45'),
(3, 'abc1@gmail.com', 'abc123', '6ca13d52ca70c883e0f0bb101e425a89e8624de51db2d2392593af6a84118090', '2025-05-29 05:22:47'),
(4, 'yus@gmail.com', 'yusron0', 'bd58149dc356e0f822e4afe25a39a5786d225a235e7223ff1d04e8679daa648e', '2025-05-29 05:35:36'),
(5, 'qwe12@gmail.com', 'qwerty', '65e84be33532fb784c48129675f9eff3a682b27168c0ea744b2cf58ee02337c5', '2025-05-29 05:37:23'),
(6, 'abcd@gmail.com', 'abcdef', 'bef57ec7f53a6d40beb640a780a639c83bc29ac8a9816f1fc6c5c6dcd93c4721', '2025-05-29 05:42:23');

-- --------------------------------------------------------

--
-- Table structure for table `bookings`
--

CREATE TABLE `bookings` (
  `id_booking` int(11) NOT NULL,
  `id_customer` int(11) NOT NULL,
  `id_movie` int(11) NOT NULL,
  `movie_title` varchar(100) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `seat` varchar(255) NOT NULL,
  `purchased_date` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `total_amount` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id_customer` int(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `password` varchar(255) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id_customer`, `username`, `email`, `password`, `created_at`) VALUES
(1, 'yusron', 'yusron20@gmail.com', '4f4571209f9bf4273b411c1180ca1f0516d3487006643f89c0e3bf2458ff1466', '2025-05-25 12:49:24'),
(4, 'yusron1', 'yusron@gmail.com', '8a4318b50b5da60422fd57e28be19beff53c4953bc9162342520d4c36d5fe7de', '2025-05-25 12:50:56'),
(6, 'yusron2004', 'yzr20@gmail.com', '00d6e90f2e697109e0a0de4b91fad944dbd385c89918ea8ecad96ed0521666cc', '2025-05-29 04:19:56'),
(7, 'afif12', 'yzr@gmail.com', 'b9fbe38cf2668eca8e06a1d95e271dc51f1ef02b1832bd5e3ccfca6f496141e7', '2025-05-29 04:44:27'),
(8, 'aklq12', 'afif12@gmail.com', 'd953ce5d14f2d1ed16b74876d8abefedd3a2bfa48183787d585de44c8b7b4431', '2025-05-29 04:46:44'),
(9, 'afif123', 'afif@gmail.com', 'd953ce5d14f2d1ed16b74876d8abefedd3a2bfa48183787d585de44c8b7b4431', '2025-05-29 05:03:45');

-- --------------------------------------------------------

--
-- Table structure for table `movies`
--

CREATE TABLE `movies` (
  `id_movie` int(11) NOT NULL,
  `movie_title` varchar(100) NOT NULL,
  `genre` varchar(255) NOT NULL,
  `rating` decimal(3,1) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `time` time NOT NULL,
  `showtime` time NOT NULL,
  `content_rating` varchar(10) NOT NULL,
  `description` text DEFAULT NULL,
  `screen` varchar(20) NOT NULL,
  `ticket_price` int(11) NOT NULL,
  `uri` varchar(255) DEFAULT NULL,
  `poster` longblob DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp(),
  `updated_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `movies`
--

INSERT INTO `movies` (`id_movie`, `movie_title`, `genre`, `rating`, `date`, `time`, `showtime`, `content_rating`, `description`, `screen`, `ticket_price`, `uri`, `poster`, `created_at`, `updated_at`) VALUES
(1, 'Avengers: Endgame', 'Action/Sci-Fi', 5.0, '2025-06-22', '03:01:50', '16:45:00', '5', 'After Thanos, an intergalactic warlord, disintegrates half of the universe, the Avengers must reunite and assemble again to reinvigorate their trounced allies and restore balance.', 'Studio 2', 40000, NULL, NULL, '2025-05-30 04:10:01', '2025-05-31 00:03:13'),
(3, 'The Amazing Spider-Man 3', 'Action', 5.0, '2025-06-28', '02:58:40', '14:45:50', '5', 'Peter Parker, an outcast high school student, gets bitten by a radioactive spider and attains superpowers. While unravelling his parents\' disappearance, he must fight against the Lizard.', 'Studio 3', 40000, NULL, NULL, '2025-05-31 00:08:48', '2025-05-31 00:08:48');

-- --------------------------------------------------------

--
-- Table structure for table `screens`
--

CREATE TABLE `screens` (
  `id` int(11) NOT NULL,
  `screen_name` varchar(20) NOT NULL,
  `capacity` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_admin`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Indexes for table `bookings`
--
ALTER TABLE `bookings`
  ADD PRIMARY KEY (`id_booking`),
  ADD KEY `userid` (`id_customer`),
  ADD KEY `booked_movie_id` (`id_movie`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id_customer`),
  ADD UNIQUE KEY `username` (`username`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indexes for table `movies`
--
ALTER TABLE `movies`
  ADD PRIMARY KEY (`id_movie`);

--
-- Indexes for table `screens`
--
ALTER TABLE `screens`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `screen_name` (`screen_name`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `bookings`
--
ALTER TABLE `bookings`
  MODIFY `id_booking` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id_customer` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `movies`
--
ALTER TABLE `movies`
  MODIFY `id_movie` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `screens`
--
ALTER TABLE `screens`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bookings`
--
ALTER TABLE `bookings`
  ADD CONSTRAINT `bookings_ibfk_1` FOREIGN KEY (`id_customer`) REFERENCES `customer` (`id_customer`),
  ADD CONSTRAINT `bookings_ibfk_2` FOREIGN KEY (`id_movie`) REFERENCES `booked_movie` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
