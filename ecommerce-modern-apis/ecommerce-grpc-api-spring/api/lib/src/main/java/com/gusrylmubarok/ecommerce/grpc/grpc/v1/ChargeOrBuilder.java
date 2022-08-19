// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: PaymentGatewayService.proto

package com.gusrylmubarok.ecommerce.grpc.grpc.v1;

public interface ChargeOrBuilder extends
    // @@protoc_insertion_point(interface_extends:com.gusrylmubarok.v1.Charge)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * Unique identifier for the object.
   * </pre>
   *
   * <code>string id = 1;</code>
   * @return The id.
   */
  java.lang.String getId();
  /**
   * <pre>
   * Unique identifier for the object.
   * </pre>
   *
   * <code>string id = 1;</code>
   * @return The bytes for id.
   */
  com.google.protobuf.ByteString
      getIdBytes();

  /**
   * <pre>
   *positive integer or zero
   *Amount intended to be collected by this payment. A positive integer representing how much to
   * charge in the smallest currency unit (e.g., 100 cents to charge $1.00 or 100 to charge ¥100,
   * a zero-decimal currency). The minimum amount is $0.50 US or equivalent in charge currency.
   * The amount value supports up to eight digits
   * (e.g., a value of 99999999 for a USD charge of $999,999.99).
   * </pre>
   *
   * <code>uint32 amount = 2;</code>
   * @return The amount.
   */
  int getAmount();

  /**
   * <pre>
   * positive integer or zero. Amount in paise captured (can be less than the amount attribute on
   * the charge if a partial capture was made).
   * </pre>
   *
   * <code>uint32 amountCaptured = 3;</code>
   * @return The amountCaptured.
   */
  int getAmountCaptured();

  /**
   * <pre>
   * positive integer or zero. Amount in paise refunded
   * (can be less than the amount attribute on the charge if a partial refund was issued).
   * </pre>
   *
   * <code>uint32 amountRefunded = 4;</code>
   * @return The amountRefunded.
   */
  int getAmountRefunded();

  /**
   * <pre>
   * ID of the balance transaction that describes the impact of this charge on your account balance
   * (not including refunds or disputes).
   * </pre>
   *
   * <code>string balanceTransactionId = 5;</code>
   * @return The balanceTransactionId.
   */
  java.lang.String getBalanceTransactionId();
  /**
   * <pre>
   * ID of the balance transaction that describes the impact of this charge on your account balance
   * (not including refunds or disputes).
   * </pre>
   *
   * <code>string balanceTransactionId = 5;</code>
   * @return The bytes for balanceTransactionId.
   */
  com.google.protobuf.ByteString
      getBalanceTransactionIdBytes();

  /**
   * <pre>
   * Billing information associated with the payment method at the time of the transaction.
   * </pre>
   *
   * <code>.com.gusrylmubarok.v1.BillingDetails billingDetails = 6;</code>
   * @return Whether the billingDetails field is set.
   */
  boolean hasBillingDetails();
  /**
   * <pre>
   * Billing information associated with the payment method at the time of the transaction.
   * </pre>
   *
   * <code>.com.gusrylmubarok.v1.BillingDetails billingDetails = 6;</code>
   * @return The billingDetails.
   */
  com.gusrylmubarok.ecommerce.grpc.grpc.v1.BillingDetails getBillingDetails();
  /**
   * <pre>
   * Billing information associated with the payment method at the time of the transaction.
   * </pre>
   *
   * <code>.com.gusrylmubarok.v1.BillingDetails billingDetails = 6;</code>
   */
  com.gusrylmubarok.ecommerce.grpc.grpc.v1.BillingDetailsOrBuilder getBillingDetailsOrBuilder();

  /**
   * <pre>
   * The full statement descriptor that is passed to card networks, and that is displayed
   * on your customers’ credit card and bank statements. Allows you to see what the
   * statement descriptor looks like after the static and dynamic portions are combined.
   * </pre>
   *
   * <code>string calculatedStatementDescriptor = 7;</code>
   * @return The calculatedStatementDescriptor.
   */
  java.lang.String getCalculatedStatementDescriptor();
  /**
   * <pre>
   * The full statement descriptor that is passed to card networks, and that is displayed
   * on your customers’ credit card and bank statements. Allows you to see what the
   * statement descriptor looks like after the static and dynamic portions are combined.
   * </pre>
   *
   * <code>string calculatedStatementDescriptor = 7;</code>
   * @return The bytes for calculatedStatementDescriptor.
   */
  com.google.protobuf.ByteString
      getCalculatedStatementDescriptorBytes();

  /**
   * <pre>
   * If the charge was created without capturing, this Boolean represents
   * whether it is still uncaptured or has since been captured.
   * </pre>
   *
   * <code>bool captured = 8;</code>
   * @return The captured.
   */
  boolean getCaptured();

  /**
   * <pre>
   * Time at which the object was created. Measured in seconds since the Unix epoch.
   * </pre>
   *
   * <code>uint64 created = 9;</code>
   * @return The created.
   */
  long getCreated();

  /**
   * <pre>
   * Three-letter ISO currency code
   * </pre>
   *
   * <code>string currency = 10;</code>
   * @return The currency.
   */
  java.lang.String getCurrency();
  /**
   * <pre>
   * Three-letter ISO currency code
   * </pre>
   *
   * <code>string currency = 10;</code>
   * @return The bytes for currency.
   */
  com.google.protobuf.ByteString
      getCurrencyBytes();

  /**
   * <pre>
   *ID of the customer this charge is for if one exists.
   * </pre>
   *
   * <code>string customerId = 11;</code>
   * @return The customerId.
   */
  java.lang.String getCustomerId();
  /**
   * <pre>
   *ID of the customer this charge is for if one exists.
   * </pre>
   *
   * <code>string customerId = 11;</code>
   * @return The bytes for customerId.
   */
  com.google.protobuf.ByteString
      getCustomerIdBytes();

  /**
   * <pre>
   * A string attached to the object for displaying to users.
   * </pre>
   *
   * <code>string description = 12;</code>
   * @return The description.
   */
  java.lang.String getDescription();
  /**
   * <pre>
   * A string attached to the object for displaying to users.
   * </pre>
   *
   * <code>string description = 12;</code>
   * @return The bytes for description.
   */
  com.google.protobuf.ByteString
      getDescriptionBytes();

  /**
   * <pre>
   * Whether the charge has been disputed.
   * </pre>
   *
   * <code>bool disputed = 13;</code>
   * @return The disputed.
   */
  boolean getDisputed();

  /**
   * <pre>
   * Error code of the failure.
   * </pre>
   *
   * <code>uint32 failureCode = 14;</code>
   * @return The failureCode.
   */
  int getFailureCode();

  /**
   * <pre>
   * Description of the failure. May state the reason if available.
   * </pre>
   *
   * <code>string failureMessage = 15;</code>
   * @return The failureMessage.
   */
  java.lang.String getFailureMessage();
  /**
   * <pre>
   * Description of the failure. May state the reason if available.
   * </pre>
   *
   * <code>string failureMessage = 15;</code>
   * @return The bytes for failureMessage.
   */
  com.google.protobuf.ByteString
      getFailureMessageBytes();

  /**
   * <pre>
   * ID of the invoice this charge is for if one exists.
   * </pre>
   *
   * <code>string invoiceId = 16;</code>
   * @return The invoiceId.
   */
  java.lang.String getInvoiceId();
  /**
   * <pre>
   * ID of the invoice this charge is for if one exists.
   * </pre>
   *
   * <code>string invoiceId = 16;</code>
   * @return The bytes for invoiceId.
   */
  com.google.protobuf.ByteString
      getInvoiceIdBytes();

  /**
   * <pre>
   * ID of the order this charge is for if one exists.
   * </pre>
   *
   * <code>string orderId = 17;</code>
   * @return The orderId.
   */
  java.lang.String getOrderId();
  /**
   * <pre>
   * ID of the order this charge is for if one exists.
   * </pre>
   *
   * <code>string orderId = 17;</code>
   * @return The bytes for orderId.
   */
  com.google.protobuf.ByteString
      getOrderIdBytes();

  /**
   * <pre>
   * Boolean value represents if the charge succeeded, or was successfully authorized for later capture, or not.
   * </pre>
   *
   * <code>bool paid = 18;</code>
   * @return The paid.
   */
  boolean getPaid();

  /**
   * <pre>
   * ID of the payment method used in this charge.
   * </pre>
   *
   * <code>string paymentMethodId = 19;</code>
   * @return The paymentMethodId.
   */
  java.lang.String getPaymentMethodId();
  /**
   * <pre>
   * ID of the payment method used in this charge.
   * </pre>
   *
   * <code>string paymentMethodId = 19;</code>
   * @return The bytes for paymentMethodId.
   */
  com.google.protobuf.ByteString
      getPaymentMethodIdBytes();

  /**
   * <pre>
   * Details about the payment method at the time of the transaction.
   * </pre>
   *
   * <code>.com.gusrylmubarok.v1.PaymentMethodDetails paymentMethodDetails = 20;</code>
   * @return Whether the paymentMethodDetails field is set.
   */
  boolean hasPaymentMethodDetails();
  /**
   * <pre>
   * Details about the payment method at the time of the transaction.
   * </pre>
   *
   * <code>.com.gusrylmubarok.v1.PaymentMethodDetails paymentMethodDetails = 20;</code>
   * @return The paymentMethodDetails.
   */
  com.gusrylmubarok.ecommerce.grpc.grpc.v1.PaymentMethodDetails getPaymentMethodDetails();
  /**
   * <pre>
   * Details about the payment method at the time of the transaction.
   * </pre>
   *
   * <code>.com.gusrylmubarok.v1.PaymentMethodDetails paymentMethodDetails = 20;</code>
   */
  com.gusrylmubarok.ecommerce.grpc.grpc.v1.PaymentMethodDetailsOrBuilder getPaymentMethodDetailsOrBuilder();

  /**
   * <pre>
   * Email where receipt of the charge would be sent.
   * </pre>
   *
   * <code>string receiptEmail = 21;</code>
   * @return The receiptEmail.
   */
  java.lang.String getReceiptEmail();
  /**
   * <pre>
   * Email where receipt of the charge would be sent.
   * </pre>
   *
   * <code>string receiptEmail = 21;</code>
   * @return The bytes for receiptEmail.
   */
  com.google.protobuf.ByteString
      getReceiptEmailBytes();

  /**
   * <pre>
   * It represents the transaction number in charge receipt that sent over email.
   * It should be remain null until a charge receipt is sent.
   * </pre>
   *
   * <code>string receiptNumber = 22;</code>
   * @return The receiptNumber.
   */
  java.lang.String getReceiptNumber();
  /**
   * <pre>
   * It represents the transaction number in charge receipt that sent over email.
   * It should be remain null until a charge receipt is sent.
   * </pre>
   *
   * <code>string receiptNumber = 22;</code>
   * @return The bytes for receiptNumber.
   */
  com.google.protobuf.ByteString
      getReceiptNumberBytes();

  /**
   * <pre>
   * Boolean field represents whether charge refunded or not.
   * </pre>
   *
   * <code>bool refunded = 23;</code>
   * @return The refunded.
   */
  boolean getRefunded();

  /**
   * <pre>
   * A list of refunds that have been applied to the charge.
   * </pre>
   *
   * <code>repeated .com.gusrylmubarok.v1.Refund refunds = 24;</code>
   */
  java.util.List<com.gusrylmubarok.ecommerce.grpc.grpc.v1.Refund> 
      getRefundsList();
  /**
   * <pre>
   * A list of refunds that have been applied to the charge.
   * </pre>
   *
   * <code>repeated .com.gusrylmubarok.v1.Refund refunds = 24;</code>
   */
  com.gusrylmubarok.ecommerce.grpc.grpc.v1.Refund getRefunds(int index);
  /**
   * <pre>
   * A list of refunds that have been applied to the charge.
   * </pre>
   *
   * <code>repeated .com.gusrylmubarok.v1.Refund refunds = 24;</code>
   */
  int getRefundsCount();
  /**
   * <pre>
   * A list of refunds that have been applied to the charge.
   * </pre>
   *
   * <code>repeated .com.gusrylmubarok.v1.Refund refunds = 24;</code>
   */
  java.util.List<? extends com.gusrylmubarok.ecommerce.grpc.grpc.v1.RefundOrBuilder> 
      getRefundsOrBuilderList();
  /**
   * <pre>
   * A list of refunds that have been applied to the charge.
   * </pre>
   *
   * <code>repeated .com.gusrylmubarok.v1.Refund refunds = 24;</code>
   */
  com.gusrylmubarok.ecommerce.grpc.grpc.v1.RefundOrBuilder getRefundsOrBuilder(
      int index);

  /**
   * <pre>
   * For card charges
   * </pre>
   *
   * <code>string statementDescriptor = 25;</code>
   * @return The statementDescriptor.
   */
  java.lang.String getStatementDescriptor();
  /**
   * <pre>
   * For card charges
   * </pre>
   *
   * <code>string statementDescriptor = 25;</code>
   * @return The bytes for statementDescriptor.
   */
  com.google.protobuf.ByteString
      getStatementDescriptorBytes();

  /**
   * <pre>
   * The status of the payment is either succeeded, pending, or failed
   * </pre>
   *
   * <code>.com.gusrylmubarok.v1.Charge.Status status = 26;</code>
   * @return The enum numeric value on the wire for status.
   */
  int getStatusValue();
  /**
   * <pre>
   * The status of the payment is either succeeded, pending, or failed
   * </pre>
   *
   * <code>.com.gusrylmubarok.v1.Charge.Status status = 26;</code>
   * @return The status.
   */
  com.gusrylmubarok.ecommerce.grpc.grpc.v1.Charge.Status getStatus();

  /**
   * <code>string sourceId = 27;</code>
   * @return The sourceId.
   */
  java.lang.String getSourceId();
  /**
   * <code>string sourceId = 27;</code>
   * @return The bytes for sourceId.
   */
  com.google.protobuf.ByteString
      getSourceIdBytes();
}
