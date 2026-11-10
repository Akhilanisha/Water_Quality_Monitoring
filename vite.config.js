import react from '@vitejs/plugin-react';
import { defineConfig, loadEnv } from 'vite';

export default defineConfig(({ mode }) => {
  const { WQM_DEV_API_TARGET } = loadEnv(mode, process.cwd(), 'WQM_DEV_API_TARGET');
  const proxy = { '/api': WQM_DEV_API_TARGET || 'http://localhost:8081' };

  return {
    plugins: [react()],
    server: { port: 3000, proxy },
    preview: { proxy },
  };
});
