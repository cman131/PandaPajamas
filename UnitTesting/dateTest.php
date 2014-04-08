<?php
require '../Source/src/wp-includes/date.php';

class DateTest extends PHPUnit_Framework_TestCase
{

	public function testGetCompare()
	{
	}

	public function testValidateColumn()
	{
	}

	public function testGetSql()
	{
		try{
			$a = new WP_Date_Query(array("4/8/2014"));

			echo $a->get_sql();
			$this->assertTrue(!$a->get_sql());
		}
		catch(Exception $e)
		{
			echo 'Message: ' .$e->getMessage();
			$this->fail();
		}
	}

	public function testBuildValue()
	{
	}

	public function testBuildMysqlDatetime()
	{
	}

	public function buildTimeQuery()
	{
	}
}
