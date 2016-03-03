package org.waman.scalatest_util

class WamanCustomSpecSpec extends WamanCustomSpec{

  "Double-value precision evaluation with %-like methods" - {

    "% should evaluate Double-value precision in a-hundredth order" in {
      __Verify__
      0.1001 should equal (%(0.1))
      0.11   should not equal %(0.1)
      -0.1001 should equal (%(-0.1))
      -0.11   should not equal %(-0.1)
      0.0 should equal (%(0.0))
    }

    "%% should evaluate Double-value precision in 10^{-4} order" in {
      __Verify__
      0.100001 should equal (%%(0.1))
      0.1001   should not equal %%(0.1)
      -0.100001 should equal (%%(-0.1))
      -0.1001   should not equal %%(-0.1)
      0.0 should equal (%%(0.0))
    }

    "% should evaluate Double-value precision in 10^{-6} order" in {
      __Verify__
      0.10000001 should equal (%%%(0.1))
      0.100001   should not equal %%%(0.1)
      -0.10000001 should equal (%%%(-0.1))
      -0.100001   should not equal %%%(-0.1)
      0.0 should equal (%%%(0.0))
    }

    "% should evaluate Double-value precision in 10^{-8} order" in {
      __Verify__
      0.1000000001 should equal (%%%%(0.1))
      0.10000001   should not equal %%%%(0.1)
      -0.1000000001 should equal (%%%%(-0.1))
      -0.10000001   should not equal %%%%(-0.1)
      0.0 should equal (%%%%(0.0))
    }

    "% should evaluate Double-value precision in 10^{-n} order" in {
      __Verify__
      0.10001 should equal (%(0.1, 3))
      0.101   should not equal %(0.1, 3)
      -0.10001 should equal (%(-0.1, 3))
      -0.101   should not equal %(-0.1, 3)
      0.0 should equal (%(0.0, 3))
    }
  }
}
