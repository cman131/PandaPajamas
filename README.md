PandaPajamas
============

Testing WordPress

## Setup
First, install [VirtualBox](https://www.virtualbox.org/wiki/Downloads), and
[vagrant](http://www.vagrantup.com/downloads.html)  Next, launch a shell and run
`vagrant up`.  This will launch a virtual machine that hosts a WordPress, and is
available at http://localhost:8080/wordpress.

### Machine Setup
Both the VM for the class and the local development machine will be configured
with the same software (installed via `apt-get` on Ubuntu).  There is a slight
chance the machine will come up and instal a later version of software than when
the VM was provisioned.

* Apache
* PHP
* MySQL

Both the development and the 'production' machine have the same username and
password configuartion by default.
