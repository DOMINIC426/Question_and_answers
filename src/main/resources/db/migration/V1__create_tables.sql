-- This will be version 1
-- Add difficulty column if it doesn't exist
DO $$
BEGIN
    IF NOT EXISTS (SELECT 1 FROM information_schema.columns
                   WHERE table_name='question' AND column_name='difficulty') THEN
ALTER TABLE question ADD COLUMN difficulty VARCHAR(20) NOT NULL DEFAULT 'EASY';
END IF;
END $$;