package com.mpc.utils;

public class RcUtils {
	public static String APPROVED					="00";
	public static String MESSAGE_LENGTH_WRONG		="2";
	public static String INVALID_MERCHANT			="3";
	public static String DO_NOT_HONOR				="4";
	public static String UNABLE_TO_PROCESS			="5";
	public static String INVALID_TRANSACTION_TERM	="6";
	public static String ISSUER_TIMEOUT				="8";
	public static String NO_ORIGINAL				="9";
	public static String UNABLE_TO_REVERSE			="10";
	public static String INVALID_TRANSACTION		="12";
	public static String INVALID_AMOUNT				="13";
	public static String AMOUNT_LESS_NOMINAL		="15";
	public static String INVALID_CARD				="14";
	public static String INVALID_CAPTURE_DATE		="17";
	public static String SYSTEM_ERROR_REENTER		="19";
	public static String NO_FROM_ACCOUNT			="20";
	public static String NO_TO_ACCOUNT				="21";
	public static String NO_CHECKING_ACCOUNT		="22";
	public static String NO_SAVING_ACCOUNT			="23";
	public static String NO_CREDIT_ACCOUNT			="24";
	public static String UNABLE_LOCATE_RECORD		="25";
	public static String MESSAGE_FORMAT_ERROR		="30";
	public static String ISSUER_BANK_NOTREGISTERED	="31";
	public static String DATE_EXPIRED				="34";
	public static String TRANSACTION_NOT_ALLOWED	="39";
	public static String HOT_CARD					="41";
	public static String SPECIAL_PICKUP				="42";
	public static String HOT_CARD_PICK_UP			="43";
	public static String PICK_UP_CARD				="44";
	public static String TXN_BACK_OFF				="45";
	public static String CHIP_OFF_DECLINED			="46";
	public static String CHIP_UNABLE_ONLINE			="47";
	public static String CHIP_ARQC_FAIL				="48";
	public static String CHIP_TAG_NOT_FOUND			="49";
	public static String NO_FUNDS					="51";
	public static String TIPE_REKENING_TIDAK_ADA	="52";
	public static String NO_REKENING_SALAH			="53";
	public static String EXPIRED_CARD				="54";
	public static String INCORRECT_PIN				="55";
	public static String NO_CARD_RECORD				="56";
	public static String DORMAN_ACCOUNT				="57";
	public static String TXN_NOT_PERMITTED_ON_CARD	="58";
	public static String SUSPECTED_FRAUD			="59";
	public static String EXCEEDS_LIMIT_DAYLY		="60";
	public static String EXCEEDS_LIMIT_TRX			="61";
	public static String ACCOUNT_BLOCKED			="62";
	public static String REKENING_BLOKIR_SALDO_SELURUH		="63";
	public static String REKENING_BLOKIR_SALDO_SEBAGIAN 	="64";
	public static String EXCEEDS_FREQ_LIMIT			="65";
	public static String EXCEEDS_ACQUIRER_LIMIT		="66";
	public static String KARTU_BLOKIR				="67";
	public static String LATE_RESPONSE				="68";
	public static String TIDAK_ADA_MUTASI			="73";
	public static String CARDLESS_BLOKIR            ="74";
	public static String EXCEEDS_PIN_RETRY			="75";
	public static String INVALID_ACCOUNT			="76";
	public static String ACCOUNT_NOT_ACTIVE			="77";
	public static String ACCOUNT_CLOSED				="78";
	public static String KEY_VALIDATION_ERROR		="79";
	public static String PIN_LENGTH_ERROR			="80";
	public static String INVALID_PIN_BLOCK			="81";
	public static String INVALID_CVV				="82";
	public static String COUNTER_SYNC_ERROR			="83";
	public static String INVALID_LIFE_CYCLE			="84";
	public static String NO_KEYS_TO_USE				="85";
	public static String KME_SYNC__ERROR			="86";
	public static String PIN_KEY_ERROR				="87";
	public static String MAC_SYNC_ERROR				="88";
	public static String SECURITY_VIOLATION			="89";
	public static String SWITCH_NOT_AVAILABLE		="91";
	public static String INVALID_ISSUER				="92";
	public static String INVALID_ACQUIRER			="93";
	public static String INVALID_ORIGINATOR			="94";
	public static String VIOLATION_LAW				="95";
	public static String SYSTEM_ERROR				="96";
	public static String NO_FUNDS_TRANSFER			="97";
	public static String DUPLICATE_REVERSAL			="98";
	public static String OTHER_ERROR				="99";
	public static String JPT_NO_	="101";
	public static String PARTIAL_DISPENSE	="102";
	public static String UNABLE_DISPENSE	="103";
	public static String LOW_RECEIPT	="104";
	public static String RPT_NO_RECEIPT	="105";
	public static String DEVICE_TIME_OUT	="106";
	public static String BOTH_PRINTER	="107";
	public static String LOW_CASH	="108";
	public static String CUSTOMER_CANCEL	="109";
	public static String HI_DISPENSER_OUT	="110";
	public static String LOW_DISPENSER_OUT	="111";
	public static String UNCERTAIN_DISPENSE	="112";
	public static String DEPOSIT_ERROR	="113";
	public static String KEY_RELOAD	="114";
	public static String CARD_RETRACT	="115";
	public static String UNDIVISIABLE_AMOUNT	="116";
	public static String TSF_AMOUNT_ZERO	="117";
	public static String INDIVISIBLE_AMOUNT	="118";
	public static String AMOUNT_TOO_LARGE	="119";
	public static String BNA_CANCEL_OR_TIMEOUT	="120";
	public static String BNA_DEPOSIT_ERROR	="121";
	public static String BNA_DEVICE_INOPERATIVE	="122";
	public static String BNA_NO_BILLS_IN_ESCROW	="123";
	public static String BNA_BILLS_AT_POWER_UP	="124";
	public static String BNA_UNABLE_TO_MOVE_BILLS	="125";
	public static String BNA_BILLS_REMAIN_IN_ESCROW	="126";
	public static String BNA_DEVICE_FAULT	="127";
	public static String BNA_VAULT_FULL	="128";
	public static String BNA_REPORTED_FAULT	="129";
	public static String SURCHARGE_AMT_NOT_PERMITTED	="131";
	public static String SURCHARGE_AMT_NOT_SUPPORTED	="132";
	public static String LM_DECLINED	="150";
	public static String DECLINED_ON_LM_TIMEOUT	="151";
	public static String FM_DECLINED	="152";
	public static String DECLINED_ON_FM_TIMEOUT	="153";
	public static String LOST_CARD	="200";
	public static String ACCOUNT_SUSPENDED	="202";
	public static String ACCOUNT_CANCELLED	="203";
	public static String ACCOUNT_INACTIVE	="204";
	public static String ACCOUNT_PAST_DUE30	="205";
	public static String ACCOUNT_PAST_DUE60	="206";
	public static String ACCOUNT_PAST_DUE90	="207";
	public static String TERMINAL_ACCESS_BAR	="208";
	public static String INVALID_TERMINAL_ID	="209";
	public static String UPDATE_LOST_CARD	="210";
	public static String INVALID_CHECK_DIGIT	="211";
	public static String HOLD_AND_CALL_ISSUER	="212";
	public static String CALL_ISSUER	="213";
	public static String OVER_CASH_ADVANCE_LIMIT	="214";
	public static String NEGATIVE_REC_ADDED	="215";
	public static String NEGATIVE_REC_EXISTED	="216";
	public static String NEGATIVE_REC_NOT_FOUND	="217";
	public static String NEGATIVE_REC_DELETED	="218";
	public static String CARD_DECLINED	="219";
	public static String NEGATIVE_FILE_DECLINED	="220";
	public static String OVER_PURCHASE_LIMIT	="221";
	public static String MERCHANT_CLOSE	="222";
	public static String OVER_AMOUNT_LIMIT	="223";
	public static String RECONFIRM	="224";
	public static String TRANSFER_ACCOUNTS_SAME	="225";
	public static String REMOTE_FILE_ERROR	="226";
	public static String CUSTOMER_FROZEN	="227";
	public static String PASSBOOK_LOST	="228";
	public static String NOT_IDENTIFIED	="229";
	public static String OWNER_DECEASED	="230";
	public static String ACCOUNT_REFER_C_R	="232";
	public static String ACCOUNT_REFER_D_R	="233";
	public static String ACCOUNT_REFER_ALL	="234";
	public static String ACCOUNT_STOPPED	="235";
	public static String DR_LIMIT_EXPIRED	="236";
	public static String CHEQUE_STOPPED	="237";
	public static String INSUFFICIENT_FUNDS	="238";
	public static String AFTER_BALANCE_ERROR	="239";
	public static String RECORD_LOCKED	="240";
	public static String NO_ACCOUNT_TRANSACTION	="241";
	public static String OVERDRAFT_NOT_ALLOWED	="242";
	public static String CURRENCY_MISMATCH	="243";
	public static String BEYOND_END_OF_DAY	="244";
	public static String CHEQUE_NO_UNKNOWN	="245";
	public static String CR_LIMIT_EXCEEDED	="246";
	public static String OD_REQUIRES_OVERRIDE	="247";
	public static String LOCATION_UNKNOWN	="248";
	public static String NO_RELATIONSHIP	="249";
	public static String SPECIAL_CARD	="250";
	public static String BAD_PIN_CHANGE1	="251";
	public static String BAD_PIN_CHANGE2	="252";
	public static String INVALID_CARD_FOR_DEVICE	="253";
	public static String EXCEEDS_TSF_LIMIT	="254";
	public static String EXCEEDS_LIMIT1	="255";
	public static String EXCEEDS_LIMIT2	="256";
	public static String GS_EXCEED_CARD_LIMIT	="257";
	public static String GS_EXCEED_PROD_LIMIT	="258";
	public static String GS_EXCEED_PROD_AMT_USED100_LMIT	="259";
	public static String GS_EXCEED_CARD_AMT_USED100_LMIT	="260";
	public static String GS_EXCEED_PROD_AMT_AMT_USED_IMIT	="261";
	public static String GS_EXCEED_CARD_AMT_AMT_USED_IMIT	="262";
	public static String WD_EXCEED_CARD_COMB_LIMIT	="263";
	public static String WD_EXCEED_PROD_COMB_LIMIT	="264";
	public static String WD_EXCEED_CARD_WD_LIMIT	="265";
	public static String WD_EXCEED_PROD_WD_LIMIT	="266";
	public static String WD_EXCEED_CARD_AMT_USED100_CMB_LIMIT	="267";
	public static String WD_EXCEED_PROD_AMT_USED100_CMB_LIMIT	="268";
	public static String WD_EXCEED_CARD_AMT_USED100_W_LIMIT	="269";
	public static String WD_EXCEED_PROD_AMT_USED100_W_LIMIT	="270";
	public static String WD_EXCEED_CARD_AMT_AMT_USED_OMB_LIMIT	="271";
	public static String WD_EXCEED_PROD_AMT_AMT_USED_OMB_LIMIT	="272";
	public static String WD_EXCEED_CARD_AMT_AMT_USED_D_LIMIT	="273";
	public static String WD_EXCEED_PROD_AMT_AMT_USED_D_LIMIT	="274";
	public static String TC_EXCEED_CARD_COMB_LIMIT	="275";
	public static String TC_EXCEED_PROD_COMB_LIMIT	="276";
	public static String TC_EXCEED_CARD_TC_LIMIT	="277";
	public static String TC_EXCEED_PROD_TC_LIMIT	="278";
	public static String TC_EXCEED_CARD_AMT_USED100_CMB_LIMIT	="279";
	public static String TC_EXCEED_PROD_AMT_USED100_CMB_LIMIT	="280";
	public static String TC_EXCEED_CARD_AMT_USED100_T_LIMIT	="281";
	public static String TC_EXCEED_PROD_AMT_USED100_T_LIMIT	="282";
	public static String TC_EXCEED_CARD_AMT_AMT_USED_OMB_LIMIT	="283";
	public static String TC_EXCEED_PROD_AMT_AMT_USED_OMB_LIMIT	="284";
	public static String TC_EXCEED_CARD_AMT_AMT_USED_C_LIMIT	="285";
	public static String TC_EXCEED_PROD_AMT_AMT_USED_C_LIMIT	="286";
	public static String TSF_EXCEED_CARD_TSF_PAY_LIMI	="287";
	public static String TSF_EXCEED_PROD_TSF_PAY_LIMI	="288";
	public static String EXCEEDS_CARD_DEPOSIT_USED_LIIT	="289";
	public static String EXCEEDS_PROD_DEPOSIT_USED_LIIT	="290";
	public static String TSF_EXCEED_CARD_AMT_AMT_USEDSF_PAY_LIMIT	="291";
	public static String TSF_EXCEED_PROD_AMT_AMT_USEDSF_PAY_LIMIT	="292";
	public static String TSF_EXCEED_CARD_TSF_LIMIT	="310";
	public static String TSF_EXCEED_PROD_TSF_LIMIT	="311";
	public static String EXCEEDS_CARD_DEPOSIT_LIMIT	="312";
	public static String EXCEEDS_PROD_DEPOSIT_LIMIT	="313";
	public static String TSF_EXCEED_CARD_AMT_AMT_USEDSF_LIMIT	="314";
	public static String TSF_EXCEED_PROD_AMT_AMT_USEDSF_LIMIT	="315";
	public static String TSF_EXCEED_CARD_USD_TXN_LIMI	="293";
	public static String EXCEEDS_DEPOSIT_LIMIT	="294";
	public static String TSF_EXCEED_PROD_USD_TXN_LIMI	="295";
	public static String TSF_EXCEED_CARD_STAFF_LIMIT	="296";
	public static String TSF_EXCEED_PROD_STAFF_LIMIT	="297";
	public static String ADJUSTMENT	="298";
	public static String TERMINAL_GENERATED_REV	="299";
	public static String INVALID_SERVICE_REQUEST	="300";
	public static String NO_RECORD_FOUND	="301";
	public static String STATUS_CHANGE_ACCEPTED	="302";
	public static String STATUS_CHANGE_REJECTED	="303";
	public static String NOT_ON_US_ISSUER	="304";
	public static String INVALID_RESPONSE_CODE	="305";
	public static String EXCEED_CASHBACK_LIMIT	="306";
	public static String EXCEEDS_FREQ_LIMIT_CARD_WD	="316";
	public static String EXCEEDS_FREQ_LIMIT_PROD_WD	="317";
	public static String EXCEEDS_FREQ_LIMIT_CARD_TC	="318";
	public static String EXCEEDS_FREQ_LIMIT_PROD_TC	="319";
	public static String TRANSFER_TO_STAFF	="320";
	public static String STOP_PAYMENT	="330";
	public static String REVOCATION_AUTH	="331";
	public static String PREAUTH_NO_REQUEST	="400";
	public static String PREAUTH_DUPLICATE_COMP	="401";
	public static String PREAUTH_EXPIRED	="402";
	public static String PREAUTH_AMT_EXCEEDED	="403";
	public static String PREAUTH_AMT_ADJUST	="404";
	public static String PURCHASE_AMOUNT_ONLY	="405";
	public static String EXCHANGE_PIN_1	="550";
	public static String EXCHANGE_PIN_2	="551";
	public static String SERVER_APPROVED	="700";
	public static String CONTINUE	="701";
	public static String SERVER_DECLINED	="702";
	public static String PRE_AUTH_REQUIRED	="703";
	public static String NO_ISSUER_ENTRY	="704";
	public static String APPROVED_NO_FORWARD	="705";
	public static String CLARIFICATION_ONE	="800";
	public static String CLARIFICATION_TWO	="801";
	public static String INVALID_C_V_V2	="802";
	public static String ISSUER_DOWN	="900";
	public static String ACQUIRER_DOWN	="901";
	public static String ORIGINATOR_DOWN	="902";
	public static String REJECT_MESSAGE	="903";
	public static String FUNCTION_NOT_SUPPORTED	="904";
	public static String SHC_TIMEOUT	="905";
	public static String TRANSFEREE_DOWN	="906";
	public static String INVALID_RECEIVER	="920";
	public static String INVALID_FILE_UPDATE_CODE	="921";
	public static String NO_ACTION_NEEDED	="922";
	public static String DB_ERROR	="923";
	public static String DB_NO_DATA	="924";
	public static String UNSOLICITED_REVERSAL	="925";
	public static String DUPLICATE_TRANSMISSION	="926";
	public static String APPROVE_DENIED_ADVICE	="927";
	public static String CALL_ACQUIRER_RESPONSE	="928";
	public static String CALL_ACQUIRER_SECURITY_RESP	="929";
	public static String SYSTEM_UP	="930";
	public static String SOFT_DOWN	="931";
	public static String SYSTEM_DOWN	="932";
	public static String PIN_NOT_CHANGED	="933";
}
