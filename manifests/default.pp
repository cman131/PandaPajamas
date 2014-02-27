class apache {
  package { 'apache2':
    ensure => installed
  }

  file { '/etc/apache2/':
    ensure => present
  }

  service { 'apache2':
    ensure    => running,
    enable    => true,
    subscribe => File['/etc/apache2/']
  }
}

class php {
  package {'php5-common':
    ensure => installed
  }

  package {'libapache2-mod-php5':
    ensure => installed
  }
}

class mysql {
  package { 'mysql-client':
    ensure => installed
  }

  package { 'mysql-server':
    ensure => installed
  }

  package { 'php5-mysql':
    ensure => installed
  }

  service { 'mysql':
    ensure => running,
  }
}

class svn {
  package { 'subversion':
    ensure => installed
  }
}


exec { 'apt-update':
  command => '/usr/bin/apt-get update'
}

include apache
include php
include mysql
include svn

file { '/var/www/test_version':
  ensure => 'link',
  target => '/vagrant/wordpress-with-tests',
}

file { '/var/www/no_test_version':
  ensure => 'link',
  target => '/vagrant/wordpress-without-tests',
}
