DROP TABLE IF EXISTS soccer_team;
CREATE TABLE soccer_team (
  id          INT PRIMARY KEY,
  name    VARCHAR(64) NOT NULL
);
DROP TABLE IF EXISTS customers_campaigns;
CREATE TABLE customers_campaigns (
  customers_campaigns_id int(11)  PRIMARY KEY ,
  customer_id int(11) NOT NULL,
  campaign_id int(11) NOT NULL,
  activated int(1) NOT NULL,
  registered_date date NOT NULL,
--   PRIMARY KEY ('customers_campaigns_id'),
--   KEY 'fk_customer' ('customer_id'),
--   KEY 'fk_campaign' ('campaign_id'),
--   CONSTRAINT 'fk_campaign' FOREIGN KEY ('campaign_id') REFERENCES 'campaigns' ('campaign_id'),
--   CONSTRAINT 'fk_customer' FOREIGN KEY ('customer_id') REFERENCES 'customers' ('customer_id')
);
