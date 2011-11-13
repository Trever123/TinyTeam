<?php
$filename = 'processed/'.$_GET['ref'];
if(file_exists($filename)){
	$file = file_get_contents($filename);
	$links = explode(",", $file);
	$formed = "";
	foreach($links as $i){
		if($i == "null"){continue;}else{
		$formed .= "<a href=\"http://$i\" target=\"_blank\">$i</a> \n";
	}}
	echo '<pre>'.$formed.'</pre>';
}else{
	echo '-1';
}
?>