package org.multibit.exchange.domainmodel;

import com.google.common.collect.Maps;
import java.util.Map;

/**
 * <p>An exchange containing many securities.</p>
 *
 * @since 0.0.1
 */
public class Exchange {

  private Map<Ticker, Security> securities = Maps.newHashMapWithExpectedSize(10);

  public void addSecurity(Ticker ticker, TradeablePair tradeablePair) throws DuplicateTickerException {
    if (securities.containsKey(ticker))
      throw new DuplicateTickerException(ticker);
    securities.put(ticker, new Security(ticker, tradeablePair));
  }
}
