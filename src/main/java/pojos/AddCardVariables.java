package pojos;


public class AddCardVariables {
        public String getlastFour() {
                return lastFour;
        }

        public void setlastFour(String lastFour) {
                this.lastFour = lastFour;
        }

        public String getcardName() {
                return cardName;
        }

        public void setcardName(String cardName) {
                this.cardName = cardName;
        }

        public String getccToken() {
                return ccToken;
        }

        public void setccToken(String ccToken) {
                this.ccToken = ccToken;
        }

        public String getexpiration() {
                return expiration;
        }

        public void setexpiration(String expiration) {
                this.expiration = expiration;
        }

        private String lastFour, cardName, ccToken, expiration;

        public String getPaymentMethodid() {
                return paymentMethodid;
        }

        public void setPaymentMethodid(String paymentMethodid) {
                this.paymentMethodid = paymentMethodid;
        }

        private String paymentMethodid;

        public boolean getisDefault() {
                return isDefault;
        }

        public void setisDefault(boolean isdefault) {
                this.isDefault = isdefault;
        }

        private boolean isDefault;
}
