<?php

// Test Class

/**
 * @group user
 */
class Tests_User extends WP_UnitTestCase {
	protected $user_ids = array();

	function setUp() {
		parent::setUp();
	}

	// test the default roles

	function test_user() {
		$this->assertTrue(true);
	}
}
