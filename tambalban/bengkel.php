<?php

include("config.php");



$sql = "SELECT * FROM bengkel";
$result = array();
$query = mysqli_query($db, $sql);
 
while($row = mysqli_fetch_array($query)){
    array_push($result, array(
    'nama_bengkel' => $row['nama_bengkel'],
    'alamat_bengkel' => $row['alamat_bengkel'],
    'telepon_bengkel' => $row['telepon_bengkel'],
    'lokasi_bengkel' => $row['lokasi_bengkel']
));
}
echo json_encode(array("result" => $result));
?>