<?php

$server = "localhost";
$user = "id13700999_teguhfaddila";
$password = "tmbl-B@N0710";
$nama_database = "id13700999_tambalban";

$db = mysqli_connect($server, $user, $password, $nama_database);

if( !$db ){
    die("Gagal terhubung dengan database: " . mysqli_connect_error());
}

?>
