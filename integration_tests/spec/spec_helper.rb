require 'rspec'
require 'capybara/rspec'

Capybara.default_driver = :selenium

module PandaPajamas
  def self.site_title
    'vm352d-test'
  end
end

if ENV['DEMO'] == 'true'
  # Slow down testing and show that it is actually doing things
  require 'selenium-webdriver'

  module ::Selenium::WebDriver::Remote
    class Bridge
      def execute(*args)
        res = raw_execute(*args)['value']
        puts res
        sleep 0.75
        res
      end
    end
  end
end
