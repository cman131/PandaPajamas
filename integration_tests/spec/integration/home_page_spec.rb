require_relative '../spec_helper'

describe 'WordPress Homepage', type: 'feature' do
  before :each do
    visit 'http://vm352d.se.rit.edu/wordpress-with-tests/src'
  end

  describe 'the site logo' do
    it 'should be the title of the site' do
      site_title = page.find('.site-title').text

      expect(site_title).to eq PandaPajamas.site_title
    end
  end

  describe 'Powered by WordPress' do
    it 'should have the link' do
      page.should have_link 'Proudly powered by WordPress'
    end

    it 'should link to the WordPress homepage' do
      link = page.find_link 'Proudly powered by WordPress'

      expect(link['href']).to eq 'http://wordpress.org/'
    end
  end
end
