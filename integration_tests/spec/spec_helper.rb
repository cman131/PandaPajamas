require 'rspec'
require 'capybara/rspec'

Capybara.default_driver = :selenium

module PandaPajamas
  def self.site_title
    'vm352d-test'
  end
end
