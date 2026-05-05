import unittest

from app import build_greeting, prepare_request


class TestApp(unittest.TestCase):
    def test_build_greeting(self):
        self.assertEqual(
            build_greeting("Alice"),
            "Hello, Alice! This is a simple Python app running in Docker."
        )

    def test_prepare_request(self):
        self.assertIn("Prepared GET request to https://example.com", prepare_request())


if __name__ == "__main__":
    unittest.main()
