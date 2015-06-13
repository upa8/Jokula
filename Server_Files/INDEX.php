<?php

	include('GCMPushMessage.php');

	$apiKey = 'AIzaSyADxc-C8pOner1TPfo4WVGy37n5WpwvxgY';
	
	//$devices = array('APA91bGpF-Zcwqb8l-9zVuWJQ3HJnmpyqV1bCXjabTjDicXe2Yk0m0ysFrGy0bdQ_dS5UJ_LxeAXRByWV_RG0IFDe9dPCUK97Bo4DInjiPEnaQ0hJX35dVik_uSUaRRdhL-EfO-Z_mdhxxCXwMTtrdZphaMILSJo9w','APA91bGD67lQHgZn7JbfXv79S-4cHOtl1qKdjAdXcfeEzaqaGtmxzRiNWuxtNmCOAtsSterGI12hPdOaLNaq0mdlao_fi0kdTM0_sckT9SpE1dF3mFF669u3-e2TeFAbv0dcLazEFqIzfbNikFl_1-G43fnYfi2x-Q','APA91bFY1nroOzuWsYvlSjWNeM_PI3Bo-Jo7AshVNCwu2htK98zTZX4f0h_ILf0WtqRFAwig1RA799aCfdBZrOWO_u2TgX2OcD0gegcPfOCuF04sqY83HwF-9IZdw8DBRHis6P5tSXYXWdGcRLWYGxzelmmclWQwZQ','APA91bFY1nroOzuWsYvlSjWNeM_PI3Bo-Jo7AshVNCwu2htK98zTZX4f0h_ILf0WtqRFAwig1RA799aCfdBZrOWO_u2TgX2OcD0gegcPfOCuF04sqY83HwF-9IZdw8DBRHis6P5tSXYXWdGcRLWYGxzelmmclWQwZQ');//;
	$devices = 'APA91bF6ZSasD9grbcpX7mIUr5W96XHMrtkZGf459CjKYcL5xNo6zfZqvsoU2C3UjI0zf8e4laqv-oQghml9bA3hpsLgJJvyPCdnZ2y3gtKZgZL03UMUv2jy9lX3Qn0hnrL4x8rT7Rn_Zw_KS7LIFN7_nVDHQwwntw';
	$message = "Sorrrryyy ";
	$an = new GCMPushMessage($apiKey);
	$an->setDevices($devices);
	$response = $an->send($message);
	
?>