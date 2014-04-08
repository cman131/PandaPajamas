<?php
require 'money.php';

class MoneyTest extends PHPUnit_Framework_TestCase
{

	public function testCanBeNegated()
	{
		$a = new Money(1);

		$b = $a->negate();

		$this->assertEquals(-1, $b->getAmount());
	}

	public function testCanBeSet()
	{
		$a = new Money(1);
		$a->setAmount(3);
		$this->assertEquals(3, $a->getAmount());
	}

	public function testCanAdd()
	{
		$a = new Money(23);
		$a->add(2);
		$this->assertEquals(25, $a->getAmount());
		$a->add(-5);
		$this->assertEquals(20, $a->getAmount());
	}
}
